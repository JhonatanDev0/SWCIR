import api from './api';
const endpoint = '/bem';

const cadastrarBens = (body) => {
    return api.post(`${endpoint}/`, body);
};

const puxarDadoBem = () => {
    return api.get(`${endpoint}/`)
}

const excluirDadoBem = (bem_id) => {
    return api.delete(`${endpoint}/${bem_id}`)
}

const userServicesBens = {
    cadastrarBens,
    puxarDadoBem,
    excluirDadoBem,
};

export default userServicesBens;