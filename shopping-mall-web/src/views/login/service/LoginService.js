import Fetch from '../../../utils/Fetch';

export const Register = '/account/register';

export default {
  register() {
    return Fetch({
      url: Register,
      method: 'get'
    });
  }
};
