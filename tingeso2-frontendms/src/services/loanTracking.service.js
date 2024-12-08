import httpClient from "../http-common";

const tracking = (rut) => {
    return httpClient.get(`/api/v1/loanTracking/rut/${rut}`);
};

const getLoanDetails = (id) => {
    return httpClient.get(`/api/v1/loanTracking/id/${id}`);
};

const updateLoan = (id, data) => {
    return httpClient.put(`/api/v1/loanTracking/`, data);
};

export default {
    tracking,
    getLoanDetails,
    updateLoan,
  };