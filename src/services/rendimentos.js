import api from './api';
const endpoint = '/rend';

const cadastrarRendimentos = (body) => {
    return api.post(`${endpoint}/`, body);
};

const puxarDadoRend = () => {
    return api.get(`${endpoint}/`)
}

const somarRend = () => {
    return api.get(`${endpoint}/sum/2`)
}

const excluirDadoRend = (rend_id) => {
    return api.delete(`${endpoint}/${rend_id}`)
}

const userServicesRend = {
    cadastrarRendimentos,
    puxarDadoRend,
    excluirDadoRend,
    somarRend,
};

export default userServicesRend;