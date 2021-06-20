import api from './api';
const endpoint = '/tipobem';

const puxarDadoTipoBem = () => {
    return api.get(`${endpoint}/`)
}


const userServicesTipoBem = {
    puxarDadoTipoBem,
};

export default userServicesTipoBem;