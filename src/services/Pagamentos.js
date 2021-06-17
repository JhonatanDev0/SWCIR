import api from './api';
const endpoint = '/pagamento';

const cadastrarPagamentos = (body) => {
    return api.post(`${endpoint}/`, body);
};

const puxarDadoPag = () => {
    return api.get(`${endpoint}/`)
}

const excluirDadoPag = (pag_id) => {
    return api.delete(`${endpoint}/${pag_id}`)
}

const userServicesPag = {
    cadastrarPagamentos,
    puxarDadoPag,
    excluirDadoPag,
};

export default userServicesPag;