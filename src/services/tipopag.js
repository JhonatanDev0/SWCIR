import api from './api';
const endpoint = '/tipopag';

const puxarDadoTipoPag= () => {
    return api.get(`${endpoint}/`)
}


const userServicesTipoPag = {
    puxarDadoTipoPag,
};

export default userServicesTipoPag;