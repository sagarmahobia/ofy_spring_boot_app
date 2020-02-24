package com.ryf.appbackend.core.controller.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ryf.appbackend.jpa.entities.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OAuthBody {


    @JsonProperty("iss")
    private String issuer;
    @JsonProperty("sub")
    private String subject;
    @JsonProperty("azp")
    private String azp;
    @JsonProperty("aud")
    private String aud;
    @JsonProperty("iat")
    private String creation;
    @JsonProperty("exp")
    private String expiration;
    @JsonProperty("email")
    private String email;
    @JsonProperty("email_verified")
    private Boolean emailVerified;
    @JsonProperty("name")
    private String name;
    @JsonProperty("picture")
    private String picture;
    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("locale")
    private String locale;


    public static void updateUser(User user, OAuthBody oAuthBody) {

        user.setGoogleId(oAuthBody.getSubject());
        user.setEmail(oAuthBody.getEmail());
        user.setEmailVerified(oAuthBody.getEmailVerified());
        user.setName(oAuthBody.getName());
        user.setPicture(oAuthBody.getPicture());
        user.setGivenName(oAuthBody.getGivenName());
        user.setFamilyName(oAuthBody.getFamilyName());
        user.setLocale(oAuthBody.getLocale());
        user.setFamilyName(oAuthBody.getFamilyName());


    }
    /*

{
  "sub": 1234567890,        // The unique ID of the user's Google Account
  "iss": "https://accounts.google.com",        // The token's issuer
  "aud": "123-abc.apps.googleusercontent.com", // Client ID assigned to your Actions project
  "iat": 233366400,         // Unix timestamp of the token's creation time
  "exp": 233370000,         // Unix timestamp of the token's expiration time
  "name": "Jan Jansen",
  "given_name": "Jan",
  "family_name": "Jansen",
  "email": "jan@gmail.com", // If present, the user's email address
  "locale": "en_US"
}


    issuer=https://accounts.google.com,
    subject=118276491082957591091,
    azp=867962858531-2n53h8085po0uri2p7bmc7hs3dh5go2k.apps.googleusercontent.com,
    aud=867962858531-d7t51gha62n6otkgajcgrccrukfu8esm.apps.googleusercontent.com,
    iat=1581974003,
    expiration=1581977603,
    email=sagarmahobia5@gmail.com,
    emailVerified=true,
    name=Sagar Mahobia,
    picture=https://lh3.googleusercontent.com/a-/AAuE7mC2C7_9xNuAOEU7ALY_jC3xZamsGAs21jlAXIV06Q=s96-c,
    givenName=Sagar,
    familyName=Mahobia,
    locale=en

   */

}
