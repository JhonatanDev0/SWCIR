import api from './api';
const endpoint = '/pagamento';

const cadastrarPagamentos = (body) => {
    return api.post(`${endpoint}/`, body);
};

const userServicesPag = {
    cadastrarPagamentos,
};

export default userServicesPag;