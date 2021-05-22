import api from './api';
const endpoint = '/bens';

const cadastrarBens = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServices = {
    cadastrarBens,
};

export default userServices;