import api from './api';
const endpoint = '/contribuinte';

const cadastrarContribuinte = (body) => {
    return api.post(`${endpoint}/`, body);
};

const userServicesCont = {
    cadastrarContribuinte,
};

export default userServicesCont;