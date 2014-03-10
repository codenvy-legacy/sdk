/*
 * CODENVY CONFIDENTIAL
 * __________________
 * 
 *  [2012] - [2014] Codenvy, S.A. 
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package com.codenvy.api.deploy;

import com.codenvy.api.user.server.TokenValidator;
import com.codenvy.api.user.server.exception.UserException;

/**
 * Temporary dummy implementation of {@link TokenValidator}.
 * 
 * @author Ann Shumilova
 */
public class TokenValidatorImpl implements TokenValidator {

    /** {@inheritDoc} */
    @Override
    public String validateToken(String token) throws UserException {
        //TODO
        return "codenvy@codenvy.com";
    }

}
