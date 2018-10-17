import Fetch from '../../../utils/Fetch';

export const Register = '/account/register';
export const Check_User_Name = '/account/checkAccount';

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
  },

  checkUserName(userName) {
    return Fetch({
      url: Check_User_Name,
      method: 'POST',
      data: userName,
      headers: {
        'Content-Type': 'application/json'
      }
    });
  },
};
