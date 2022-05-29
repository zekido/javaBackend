package com.unal.Business.Abstract;

import com.unal.Core.Entities.User;
import com.unal.Core.Utilities.Results.DataResult;
import com.unal.Core.Utilities.Results.Result;
import com.unal.Entities.Concrete.Product;


public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);

}
