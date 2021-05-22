import api from './api';
const endpoint = '/pagamentos';

const cadastrarPagamentos = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServices = {
    cadastrarPagamentos,
};

export default userServices;