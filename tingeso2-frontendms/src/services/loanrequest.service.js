import httpClient from "../http-common";

const requestLoan = (data) => {
  return httpClient.post('/api/v1/loan_requests/', data);
};

const uploadDocument = (formData) => {
  return httpClient.post('/api/v1/documents/upload', formData, {
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });
};


export default {
  requestLoan,
  uploadDocument,
};
