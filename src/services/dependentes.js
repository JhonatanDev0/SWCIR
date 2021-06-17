import api from './api';
const endpoint = '/dependentes';

const cadastrarDependentes = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const puxarDadoDep = () => {
    return api.get(`${endpoint}/`)
}

const excluirDadoDep = (dep_id) => {
    return api.delete(`${endpoint}/${dep_id}`)
}

const userServicesDep = {
    cadastrarDependentes,
    puxarDadoDep,
    excluirDadoDep,
};

export default userServicesDep;