package com.unal.Business.Concrete;

import com.unal.Business.Abstract.UserService;
import com.unal.Core.DataAccess.UserDal;
import com.unal.Core.Entities.User;
import com.unal.Core.Utilities.Results.DataResult;
import com.unal.Core.Utilities.Results.Result;
import com.unal.Core.Utilities.Results.SuccessDataResult;
import com.unal.Core.Utilities.Results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDal userDal;

    @Autowired
    public UserManager(UserDal userDal) {
        this.userDal = userDal;
    }

    @Override
    public Result add(User user) {
        userDal.save(user);
        return new SuccessResult("User başarıyla eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(
                userDal.findByEmail(email),"Email bulundu.");
    }
}
