import './App.css';
import React, { useState } from 'react';
import axios from 'axios';
import { Formik, Field, Form, FieldArray, ErrorMessage } from 'formik';
import * as Yup from 'yup';

const createEnvelopeValidationSchema = Yup.object().shape({
  descricao: Yup.string().required('Descrição é obrigatória'),
  documentoNome: Yup.string().required('Nome do documento é obrigatório'),
  documentoConteudo: Yup.string().required('Conteúdo do documento é obrigatório'),
  signatarios: Yup.array()
    .of(
      Yup.object().shape({
        emailSignatario: Yup.string().email('Email inválido').required('Email é obrigatório')
      })
    )
    .min(1, 'Pelo menos um signatário é obrigatório')
});

const downloadPDFValidationSchema = Yup.object().shape({
  idEnvelope: Yup.number().required('ID do envelope é obrigatório'),
  incluirDocs: Yup.boolean().required('Incluir documentos é obrigatório')
});

const statusEnvelopeValidationSchema = Yup.object().shape({
  idEnvelope: Yup.number().required('ID do envelope é obrigatório'),
  getLobs: Yup.string().oneOf(['true', 'false']).required('Get Lobs é obrigatório')
});

const App = () => {
  const [createEnvelopeResponse, setCreateEnvelopeResponse] = useState(null);
  const [downloadResponse, setDownloadResponse] = useState(null);
  const [statusResponse, setStatusResponse] = useState(null);
  const [error, setError] = useState(null);

  const createEnvelope = async (values) => {
    try {
      const requestData = {
        token: "hDqvhFrC11N5QypP2huHk2OOJfr1FyeQ79p1tt3JCiIoH93GbnkwxF6S60yFQoZwYCzUwZVb-Lk9KvOx1EDnvhGs8MXNidUcK+0u5QGcL3xpP9ZMHUjwlRLvjLL7oD-hPovNFo-50hVHTDejSAMbH84YR+DqYh+-",
        params: {
          Envelope: {
            descricao: values.descricao,
            Repositorio: { id: 40 },
            usarOrdem: "S",
            ConfigAuxiliar: { documentosComXMLs: "N" },
            listaDocumentos: {
              Documento: [
                {
                  nomeArquivo: values.documentoNome,
                  mimeType: "application/pdf",
                  conteudo: values.documentoConteudo
                }
              ]
            },
            listaSignatariosEnvelope: {
              SignatarioEnvelope: values.signatarios
            },
            listaObservadores: { Observador: [] },
            listaTags: { Tag: [] },
            listaInfoAdicional: { InfoAdicional: [] },
            incluirHashTodasPaginas: "S",
            permitirDespachos: "S",
            ignorarNotificacoes: "N",
            ignorarNotificacoesPendentes: "N",
            bloquearDesenhoPaginas: "S"
          },
          gerarTags: "S",
          encaminharImediatamente: "N",
          detectarCampos: "N",
          verificarDuplicidadeConteudo: "N",
          processarImagensEmSegundoPlano: "N"
        }
      };

      const res = await axios.post('http://localhost:8080/api/sendRequest', requestData);
      setCreateEnvelopeResponse(res.data);
      setError(null); // Clear previous errors if the request was successful
    } catch (err) {
      console.error('Error:', err); // Log the error to the console for debugging
      if (err.response) {
        // The request was made and the server responded with a status code that falls out of the range of 2xx
        setError(`Error: ${err.response.status} - ${err.response.statusText}\n${JSON.stringify(err.response.data)}`);
      } else if (err.request) {
        // The request was made but no response was received
        setError('Error: No response received from the server');
      } else {
        // Something happened in setting up the request that triggered an Error
        setError(`Error: ${err.message}`);
      }
    }
  };

  const downloadPDFEnvelopeDocs = async (values) => {
    try {
      const requestData = {
        idEnvelope: values.idEnvelope,
        incluirDocs: values.incluirDocs === 'true' ? 'S' : 'N',
        versaoSemCertificado: null
      };

      const res = await axios.post('http://localhost:8080/api/downloadPDFEnvelopeDocs', requestData);
      setDownloadResponse(res.data);
      setError(null); // Clear previous errors if the request was successful
    } catch (err) {
      console.error('Error:', err); // Log the error to the console for debugging
      if (err.response) {
        // The request was made and the server responded with a status code that falls out of the range of 2xx
        setError(`Error: ${err.response.status} - ${err.response.statusText}\n${JSON.stringify(err.response.data)}`);
      } else if (err.request) {
        // The request was made but no response was received
        setError('Error: No response received from the server');
      } else {
        // Something happened in setting up the request that triggered an Error
        setError(`Error: ${err.message}`);
      }
    }
  };

  const consultarStatusEnvelope = async (values) => {
    try {
      const getLobsValue = values.getLobs === 'true' ? 'S' : 'N';
      const requestData = {
        token: "hDqvhFrC11N5QypP2huHk2OOJfr1FyeQ79p1tt3JCiIoH93GbnkwxF6S60yFQoZwYCzUwZVb-Lk9KvOx1EDnvhGs8MXNidUcK+0u5QGcL3xpP9ZMHUjwlRLvjLL7oD-hPovNFo-50hVHTDejSAMbH84YR+DqYh+-", // Token fixo
        params: {
          idEnvelope: values.idEnvelope,
          getLobs: getLobsValue
        }
      };

      console.log("Request Data for Consultar Status:", requestData);

      const res = await axios.post('http://localhost:8080/api/consultarStatusEnvelope', requestData);
      setStatusResponse(res.data);
      setError(null); // Clear previous errors if the request was successful
    } catch (err) {
      console.error('Error:', err); // Log the error to the console for debugging
      if (err.response) {
        // The request was made and the server responded with a status code that falls out of the range of 2xx
        setError(`Error: ${err.response.status} - ${err.response.statusText}\n${JSON.stringify(err.response.data)}`);
      } else if (err.request) {
        // The request was made but no response was received
        setError('Error: No response received from the server');
      } else {
        // Something happened in setting up the request that triggered an Error
        setError(`Error: ${err.message}`);
      }
    }
  };

  return (
    <div>
      <h1>React Frontend</h1>
      <h2>Criar e encaminhar envelope</h2>
      <Formik
        initialValues={{
          descricao: '',
          documentoNome: '',
          documentoConteudo: '',
          signatarios: [{ emailSignatario: '' }]
        }}
        validationSchema={createEnvelopeValidationSchema}
        onSubmit={(values, { setSubmitting }) => {
          createEnvelope(values);
          setSubmitting(false);
        }}
      >
        {({ values, isSubmitting }) => (
          <Form>
            <div>
              <label>Descrição:</label>
              <Field type="text" name="descricao" />
              <ErrorMessage name="descricao" component="div" style={{ color: 'red' }} />
            </div>
            <div>
              <label>Nome do Documento:</label>
              <Field type="text" name="documentoNome" />
              <ErrorMessage name="documentoNome" component="div" style={{ color: 'red' }} />
            </div>
            <div>
              <label>Conteúdo do Documento:</label>
              <Field as="textarea" name="documentoConteudo" />
              <ErrorMessage name="documentoConteudo" component="div" style={{ color: 'red' }} />
            </div>
            <div>
              <label>Signatários:</label>
              <FieldArray name="signatarios">
                {({ insert, remove, push }) => (
                  <div>
                    {values.signatarios.length > 0 &&
                      values.signatarios.map((signatario, index) => (
                        <div key={index}>
                          <Field
                            name={`signatarios.${index}.emailSignatario`}
                            type="email"
                            placeholder="Email do signatário"
                          />
                          <ErrorMessage
                            name={`signatarios.${index}.emailSignatario`}
                            component="div"
                            style={{ color: 'red' }}
                          />
                          <button
                            type="button"
                            onClick={() => remove(index)}
                          >
                            Remover
                          </button>
                        </div>
                      ))}
                    <button
                      type="button"
                      onClick={() => push({ emailSignatario: '' })}
                    >
                      Adicionar Signatário
                    </button>
                  </div>
                )}
              </FieldArray>
            </div>
            <button type="submit" disabled={isSubmitting}>
              Criar Envelope
            </button>
          </Form>
        )}
      </Formik>
      {createEnvelopeResponse && <div>Response: {JSON.stringify(createEnvelopeResponse)}</div>}
      
      <h2>Baixar PDF do Envelope e salvar no banco</h2>
      <Formik
        initialValues={{
          idEnvelope: '',
          incluirDocs: 'false'
        }}
        validationSchema={downloadPDFValidationSchema}
        onSubmit={(values, { setSubmitting }) => {
          downloadPDFEnvelopeDocs(values);
          setSubmitting(false);
        }}
      >
        {({ isSubmitting }) => (
          <Form>
            <div>
              <label>ID do Envelope:</label>
              <Field type="text" name="idEnvelope" />
              <ErrorMessage name="idEnvelope" component="div" style={{ color: 'red' }} />
            </div>
            <div>
              <label>Incluir Documentos:</label>
              <div role="group" aria-labelledby="incluirDocs">
                <label>
                  <Field type="radio" name="incluirDocs" value="true" />
                  Sim
                </label>
                <label>
                  <Field type="radio" name="incluirDocs" value="false" />
                  Não
                </label>
              </div>
              <ErrorMessage name="incluirDocs" component="div" style={{ color: 'red' }} />
            </div>
            <button type="submit" disabled={isSubmitting}>
              Download PDF
            </button>
          </Form>
        )}
      </Formik>
      {downloadResponse && <div>Download Response: {JSON.stringify(downloadResponse)}</div>}

      <h2>Consultar status do envelope</h2>
      <Formik
        initialValues={{
          idEnvelope: '',
          getLobs: 'false'
        }}
        validationSchema={statusEnvelopeValidationSchema}
        onSubmit={(values, { setSubmitting }) => {
          consultarStatusEnvelope(values);
          setSubmitting(false);
        }}
      >
        {({ isSubmitting }) => (
          <Form>
            <div>
              <label>ID do Envelope:</label>
              <Field type="text" name="idEnvelope" />
              <ErrorMessage name="idEnvelope" component="div" style={{ color: 'red' }} />
            </div>
            <div>
              <label>Lobs:</label>
              <div role="group" aria-labelledby="getLobs">
                <label>
                  <Field type="radio" name="getLobs" value="true" />
                  Sim
                </label>
                <label>
                  <Field type="radio" name="getLobs" value="false" />
                  Não
                </label>
              </div>
              <ErrorMessage name="getLobs" component="div" style={{ color: 'red' }} />
            </div>
            <button type="submit" disabled={isSubmitting}>
              Consultar Status
            </button>
          </Form>
        )}
      </Formik>
      {statusResponse && <div>Status: {JSON.stringify(statusResponse)}</div>}
      
      {error && <div style={{ color: 'red' }}>Error: {error}</div>}

    </div>
  );
};


export default App;
