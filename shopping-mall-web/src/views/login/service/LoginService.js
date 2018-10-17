import Fetch from '../../../utils/Fetch';

export const Register = '/account/register';

export default {
  register(registerForm) {
    return Fetch({
      url: Register,
      method: 'POST',
      data: registerForm,
      headers: {
        'Content-Type': 'application/json'
      }
    });
  }
};
