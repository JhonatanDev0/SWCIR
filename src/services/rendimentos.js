import api from './api';
const endpoint = '/rend';

const cadastrarRendimentos = (body) => {
    return api.post(`${endpoint}/`, body);
};

const userServicesRend = {
    cadastrarRendimentos,
};

export default userServicesRend;