import api from './api';
const endpoint = '/rendimentos';

const cadastrarRendimentos = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServicesRend = {
    cadastrarRendimentos,
};

export default userServicesRend;