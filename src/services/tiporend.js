import api from './api';
const endpoint = '/tiporend';

const puxarDadoTipoRend = () => {
    return api.get(`${endpoint}/`)
}


const userServicesTipoRend = {
    puxarDadoTipoRend,
};

export default userServicesTipoRend;