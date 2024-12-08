import httpClient from "../http-common";

const getDocumentByLoanId = async (loanRequestId, type) => {
    const response = await httpClient.get(`/api/v1/getDocuments/getByLoanId/${loanRequestId}`, {
      params: { type },
      responseType: 'blob',
    });
    return response.data;
  };

const tracking = (rut) => {
    return httpClient.get(`/api/v1/loanEvaluation/rut/${rut}`);
};

const getLoanDetails = (id) => {
    return httpClient.get(`/api/v1/loanEvaluation/id/${id}`);
};

const updateLoan = (id, data) => {
    return httpClient.put(`/api/v1/loanEvaluation/`, data);
};

export default {
    tracking,
    getLoanDetails,
    updateLoan,
    getDocumentByLoanId,
  };