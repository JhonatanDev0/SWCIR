import api from './api';
const endpoint = '/user';

const cadastrarContribuinte = (body) => {
    return api.post(`${endpoint}/`, body);
};

const puxarDadoContribuinte = () => {
    return api.get(`${endpoint}/`)
}

const excluirDadoContribuinte = (user_id) => {
    return api.delete(`${endpoint}/${user_id}`)
}

/*const mudarDadoContribuinte = (user_id) => {
    return api.put(`${endpoint}/${user_id}`)
}*/

const userServicesCont = {
    cadastrarContribuinte,
    puxarDadoContribuinte,
    excluirDadoContribuinte,
};

export default userServicesCont;