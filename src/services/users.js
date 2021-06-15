import api from './api';
const endpoint = '/user';

const cadastrarContribuinte = (body) => {
    return api.post(`${endpoint}/`, body);
};

const userServicesCont = {
    cadastrarContribuinte,
};

export default userServicesCont;