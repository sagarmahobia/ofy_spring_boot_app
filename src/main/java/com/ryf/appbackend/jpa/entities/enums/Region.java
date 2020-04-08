package com.ryf.appbackend.jpa.entities.enums;

public enum Region {


    // @formatter:off
    WW("Global"),


    DV("Multiple Region"),// DV - diverse , multiple

    OL("Online"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Andorra">Andorra</a>
     */

    AD("Andorra"),

    /**
     * <a href="http://en.wikipedia.org/wiki/United_Arab_Emirates">United Arab Emirates</a>
     */
    AE("United Arab Emirates"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Afghanistan">Afghanistan</a>
     */
    AF("Afghanistan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Antigua_and_Barbuda">Antigua and Barbuda</a>
     */
    AG("Antigua and Barbuda"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Anguilla">Anguilla</a>
     */
    AI("Anguilla"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Albania">Albania</a>
     */
    AL("Albania"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Armenia">Armenia</a>
     */
    AM("Armenia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Netherlands_Antilles">Netherlands Antilles</a>
     */
    AN("Netherlands Antilles"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Angola">Angola</a>
     */
    AO("Angola"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Antarctica">Antarctica</a>
     */
    AQ("Antarctica"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Argentina">Argentina</a>
     */
    AR("Argentina"),

    /**
     * <a href="http://en.wikipedia.org/wiki/American_Samoa">American Samoa</a>
     */
    AS("American Samoa"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Austria">Austria</a>
     */
    AT("Austria"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Australia">Australia</a>
     */
    AU("Australia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Aruba">Aruba</a>
     */
    AW("Aruba"),

    /**
     * <a href="http://en.wikipedia.org/wiki/%C3%85land_Islands">&Aring;land Islands</a>
     */
    AX("\u212Bland Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Azerbaijan">Azerbaijan</a>
     */
    AZ("Azerbaijan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bosnia_and_Herzegovina">Bosnia and Herzegovina</a>
     */
    BA("Bosnia and Herzegovina"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Barbados">Barbados</a>
     */
    BB("Barbados"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bangladesh">Bangladesh</a>
     */
    BD("Bangladesh"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Belgium">Belgium</a>
     */
    BE("Belgium"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Burkina_Faso">Burkina Faso</a>
     */
    BF("Burkina Faso"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bulgaria">Bulgaria</a>
     */
    BG("Bulgaria"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bahrain">Bahrain</a>
     */
    BH("Bahrain"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Burundi">Burundi</a>
     */
    BI("Burundi"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Benin">Benin</a>
     */
    BJ("Benin"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Saint_Barth%C3%A9lemy">Saint Barth&eacute;lemy</a>
     */
    BL("Saint Barth\u00E9lemy"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bermuda">Bermuda</a>
     */
    BM("Bermuda"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Brunei">Brunei Darussalam</a>
     */
    BN("Brunei Darussalam"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bolivia">Plurinational State of Bolivia</a>
     */
    BO("Plurinational State of Bolivia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Caribbean_Netherlands">Bonaire, Sint Eustatius and Saba</a>
     */
    BQ("Bonaire, Sint Eustatius and Saba"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Brazil">Brazil</a>
     */
    BR("Brazil"),

    /**
     * <a href="http://en.wikipedia.org/wiki/The_Bahamas">Bahamas</a>
     */
    BS("Bahamas"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bhutan">Bhutan</a>
     */
    BT("Bhutan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Bouvet_Island">Bouvet Island</a>
     */
    BV("Bouvet Island"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Botswana">Botswana</a>
     */
    BW("Botswana"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Belarus">Belarus</a>
     */
    BY("Belarus"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Belize">Belize</a>
     */
    BZ("Belize"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Canada">Canada</a>
     */
    CA("Canada"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cocos_(Keeling)_Islands">Cocos (Keeling) Islands</a>
     */
    CC("Cocos Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Democratic_Republic_of_the_Congo">The Democratic Republic of the Congo</a>
     */
    CD("The Democratic Republic of the Congo"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Central_African_Republic">Central African Republic</a>
     */
    CF("Central African Republic"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Republic_of_the_Congo">Congo</a>
     */
    CG("Congo"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Switzerland">Switzerland</a>
     */
    CH("Switzerland"),

    /**
     * <a href="http://en.wikipedia.org/wiki/C%C3%B4te_d%27Ivoire">C&ocirc;te d'Ivoire</a>
     */
    CI("C\u00F4te d'Ivoire"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cook_Islands">Cook Islands</a>
     */
    CK("Cook Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Chile">Chile</a>
     */
    CL("Chile"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cameroon">Cameroon</a>
     */
    CM("Cameroon"),

    /**
     * <a href="http://en.wikipedia.org/wiki/China">China</a>
     */
    CN("China"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Colombia">Colombia</a>
     */
    CO("Colombia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Costa_Rica">Costa Rica</a>
     */
    CR("Costa Rica"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cuba">Cuba</a>
     */
    CU("Cuba"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cape_Verde">Cape Verde</a>
     */
    CV("Cape Verde"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cura%C3%A7ao">Cura&ccedil;ao</a>
     */
    CW("Cura/u00E7ao"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Christmas_Island">Christmas Island</a>
     */
    CX("Christmas Island"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cyprus">Cyprus</a>
     */
    CY("Cyprus"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Czech_Republic">Czech Republic</a>
     */
    CZ("Czech Republic"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Germany">Germany</a>
     */
    DE("Germany"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Djibouti">Djibouti </a>
     */
    DJ("Djibouti"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Denmark">Denmark</a>
     */
    DK("Denmark"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Dominica">Dominica</a>
     */
    DM("Dominica"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Dominican_Republic">Dominican Republic</a>
     */
    DO("Dominican Republic"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Algeria">Algeria</a>
     */
    DZ("Algeria"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Ecuador">Ecuador</a>
     */
    EC("Ecuador"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Estonia">Estonia</a>
     */
    EE("Estonia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Egypt">Egypt</a>
     */
    EG("Egypt"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Western_Sahara">Western Sahara</a>
     */
    EH("Western Sahara"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Eritrea">Eritrea</a>
     */
    ER("Eritrea"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Spain">Spain</a>
     */
    ES("Spain"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Ethiopia">Ethiopia</a>
     */
    ET("Ethiopia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Finland">Finland</a>
     */
    FI("Finland"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Fiji">Fiji</a>
     */
    FJ("Fiji"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Falkland_Islands">Falkland Islands (Malvinas)</a>
     */
    FK("Falkland Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Federated_States_of_Micronesia">Federated States of Micronesia</a>
     */
    FM("Federated States of Micronesia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Faroe_Islands">Faroe Islands</a>
     */
    FO("Faroe Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/France">France</a>
     */
    FR("France"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Gabon">Gabon </a>
     */
    GA("Gabon"),

    /**
     * <a href="http://en.wikipedia.org/wiki/United_Kingdom">United Kingdom</a>
     */
    GB("United Kingdom"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Grenada">Grenada</a>
     */
    GD("Grenada"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Georgia_(country)">Georgia</a>
     */
    GE("Georgia"),


    GV("Geneva"),

    /**
     * <a href="http://en.wikipedia.org/wiki/French_Guiana">French Guiana</a>
     */
    GF("French Guiana"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Guernsey">Guemsey</a>
     */
    GG("Guemsey"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Ghana">Ghana</a>
     */
    GH("Ghana"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Gibraltar">Gibraltar</a>
     */
    GI("Gibraltar"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Greenland">Greenland</a>
     */
    GL("Greenland"),

    /**
     * <a href="http://en.wikipedia.org/wiki/The_Gambia">Gambia</a>
     */
    GM("Gambia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Guinea">Guinea</a>
     */
    GN("Guinea"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Guadeloupe">Guadeloupe</a>
     */
    GP("Guadeloupe"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Equatorial_Guinea">Equatorial Guinea</a>
     */
    GQ("Equatorial Guinea"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Greece">Greece</a>
     */
    GR("Greece"),

    /**
     * <a href="http://en.wikipedia.org/wiki/South_Georgia_and_the_South_Sandwich_Islands">South Georgia and the South Sandwich Islands</a>
     */
    GS("South Georgia and the South Sandwich Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Guatemala">Guatemala</a>
     */
    GT("Guatemala"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Guam">Guam</a>
     */
    GU("Guam"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Guinea-Bissau">Guinea-Bissau</a>
     */
    GW("Guinea-Bissau"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Guyana">Guyana</a>
     */
    GY("Guyana"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Hong_Kong">Hong Kong</a>
     */
    HK("Hong Kong"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Heard_Island_and_McDonald_Islands">Heard Island and McDonald Islands</a>
     */
    HM("Heard Island and McDonald Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Honduras">Honduras</a>
     */
    HN("Honduras"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Croatia">Croatia</a>
     */
    HR("Croatia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Haiti">Haiti</a>
     */
    HT("Haiti"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Hungary">Hungary</a>
     */
    HU("Hungary"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Indonesia">Indonesia</a>
     */
    ID("Indonesia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Republic_of_Ireland">Ireland</a>
     */
    IE("Ireland"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Israel">Israel</a>
     */
    IL("Israel"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Isle_of_Man">Isle of Man</a>
     */
    IM("Isle of Man"),

    /**
     * <a href="http://en.wikipedia.org/wiki/India">India</a>
     */
    IN("India"),

    /**
     * <a href="http://en.wikipedia.org/wiki/British_Indian_Ocean_Territory">British Indian Ocean Territory</a>
     */
    IO("British Indian Ocean Territory"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Iraq">Iraq</a>
     */
    IQ("Iraq"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Iran">Islamic Republic of Iran</a>
     */
    IR("Islamic Republic of Iran"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Iceland">Iceland</a>
     */
    IS("Iceland"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Italy">Italy</a>
     */
    IT("Italy"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Jersey">Jersey</a>
     */
    JE("Jersey"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Jamaica">Jamaica</a>
     */
    JM("Jamaica"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Jordan">Jordan</a>
     */
    JO("Jordan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Japan">Japan</a>
     */
    JP("Japan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Kenya">Kenya</a>
     */
    KE("Kenya"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Kyrgyzstan">Kyrgyzstan</a>
     */
    KG("Kyrgyzstan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cambodia">Cambodia</a>
     */
    KH("Cambodia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Kiribati">Kiribati</a>
     */
    KI("Kiribati"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Comoros">Comoros</a>
     */
    KM("Comoros"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Saint_Kitts_and_Nevis">Saint Kitts and Nevis</a>
     */
    KN("Saint Kitts and Nevis"),

    /**
     * <a href="http://en.wikipedia.org/wiki/North_Korea">Democratic People's Republic of Korea</a>
     */
    KP("North Korea"),

    /**
     * <a href="http://en.wikipedia.org/wiki/South_Korea">Republic of Korea</a>
     */
    KR("South Korea"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Kuwait">Kuwait</a>
     */
    KW("Kuwait"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Cayman_Islands">Cayman Islands</a>
     */
    KY("Cayman Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Kazakhstan">Kazakhstan</a>
     */
    KZ("Kazakhstan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Laos">Lao People's Democratic Republic</a>
     */
    LA("Lao People's Democratic Republic"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Lebanon">Lebanon</a>
     */
    LB("Lebanon"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Saint_Lucia">Saint Lucia</a>
     */
    LC("Saint Lucia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Liechtenstein">Liechtenstein</a>
     */
    LI("Liechtenstein"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Sri_Lanka">Sri Lanka</a>
     */
    LK("Sri Lanka"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Liberia">Liberia</a>
     */
    LR("Liberia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Lesotho">Lesotho</a>
     */
    LS("Lesotho"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Lithuania">Lithuania</a>
     */
    LT("Lithuania"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Luxembourg">Luxembourg</a>
     */
    LU("Luxembourg"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Latvia">Latvia</a>
     */
    LV("Latvia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Libya">Libya</a>
     */
    LY("Libya"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Morocco">Morocco</a>
     */
    MA("Morocco"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Monaco">Monaco</a>
     */
    MC("Monaco"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Moldova">Republic of Moldova</a>
     */
    MD("Republic of Moldova"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Montenegro">Montenegro</a>
     */
    ME("Montenegro"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Collectivity_of_Saint_Martin">Saint Martin (French part)</a>
     */
    MF("Saint Martin"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Madagascar">Madagascar</a>
     */
    MG("Madagascar"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Marshall_Islands">Marshall Islands</a>
     */
    MH("Marshall Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Republic_of_Macedonia">The former Yugoslav Republic of Macedonia</a>
     */
    MK("The former Yugoslav Republic of Macedonia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Mali">Mali</a>
     */
    ML("Mali"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Myanmar">Myanmar</a>
     */
    MM("Myanmar"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Mongolia">Mongolia</a>
     */
    MN("Mongolia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Macau">Macao</a>
     */
    MO("Macao"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Northern_Mariana_Islands">Northern Mariana Islands</a>
     */
    MP("Northern Mariana Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Martinique">Martinique</a>
     */
    MQ("Martinique"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Mauritania">Mauritania</a>
     */
    MR("Mauritania"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Montserrat">Montserrat</a>
     */
    MS("Montserrat"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Malta">Malta</a>
     */
    MT("Malta"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Mauritius">Mauritius</a>
     */
    MU("Mauritius"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Maldives">Maldives</a>
     */
    MV("Maldives"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Malawi">Malawi</a>
     */
    MW("Malawi"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Mexico">Mexico</a>
     */
    MX("Mexico"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Malaysia">Malaysia</a>
     */
    MY("Malaysia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Mozambique">Mozambique</a>
     */
    MZ("Mozambique"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Namibia">Namibia</a>
     */
    NA("Namibia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/New_Caledonia">New Caledonia</a>
     */
    NC("New Caledonia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Niger">Niger</a>
     */
    NE("Niger"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Norfolk_Island">Norfolk Island</a>
     */
    NF("Norfolk Island"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Nigeria">Nigeria</a>
     */
    NG("Nigeria"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Nicaragua">Nicaragua</a>
     */
    NI("Nicaragua"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Netherlands">Netherlands</a>
     */
    NL("Netherlands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Norway">Norway</a>
     */
    NO("Norway"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Nepal">Nepal</a>
     */
    NP("Nepal"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Nauru">Nauru</a>
     */
    NR("Nauru"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Niue">Niue</a>
     */
    NU("Niue"),

    /**
     * <a href="http://en.wikipedia.org/wiki/New_Zealand">New Zealand</a>
     */
    NZ("New Zealand"),

    /**
     * <a href=http://en.wikipedia.org/wiki/Oman"">Oman</a>
     */
    OM("Oman"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Panama">Panama</a>
     */
    PA("Panama"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Peru">Peru</a>
     */
    PE("Peru"),

    /**
     * <a href="http://en.wikipedia.org/wiki/French_Polynesia">French Polynesia</a>
     */
    PF("French Polynesia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Papua_New_Guinea">Papua New Guinea</a>
     */
    PG("Papua New Guinea"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Philippines">Philippines</a>
     */
    PH("Philippines"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Pakistan">Pakistan</a>
     */
    PK("Pakistan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Poland">Poland</a>
     */
    PL("Poland"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Saint_Pierre_and_Miquelon">Saint Pierre and Miquelon</a>
     */
    PM("Saint Pierre and Miquelon"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Pitcairn_Islands">Pitcairn</a>
     */
    PN("Pitcairn"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Puerto_Rico">Puerto Rico</a>
     */
    PR("Puerto Rico"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Palestinian_territories">Occupied Palestinian Territory</a>
     */
    PS("Occupied Palestinian Territory"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Portugal">Portugal</a>
     */
    PT("Portugal"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Palau">Palau</a>
     */
    PW("Palau"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Paraguay">Paraguay</a>
     */
    PY("Paraguay"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Qatar">Qatar</a>
     */
    QA("Qatar"),

    /**
     * <a href="http://en.wikipedia.org/wiki/R%C3%A9union">R&eacute;union</a>
     */
    RE("R\u00E9union"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Romania">Romania</a>
     */
    RO("Romania"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Serbia">Serbia</a>
     */
    RS("Serbia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Russia">Russian Federation</a>
     */
    RU("Russian Federation"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Rwanda">Rwanda</a>
     */
    RW("Rwanda"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Saudi_Arabia">Saudi Arabia</a>
     */
    SA("Saudi Arabia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Solomon_Islands">Solomon Islands</a>
     */
    SB("Solomon Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Seychelles">Seychelles</a>
     */
    SC("Seychelles"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Sudan">Sudan</a>
     */
    SD("Sudan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Sweden">Sweden</a>
     */
    SE("Sweden"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Singapore">Singapore</a>
     */
    SG("Singapore"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Saint_Helena,_Ascension_and_Tristan_da_Cunha">Saint Helena, Ascension and Tristan da Cunha</a>
     */
    SH("Saint Helena, Ascension and Tristan da Cunha"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Slovenia">Slovenia</a>
     */
    SI("Slovenia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Svalbard_and_Jan_Mayen">Svalbard and Jan Mayen</a>
     */
    SJ("Svalbard and Jan Mayen"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Slovakia">Slovakia</a>
     */
    SK("Slovakia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Sierra_Leone">Sierra Leone</a>
     */
    SL("Sierra Leone"),

    /**
     * <a href="http://en.wikipedia.org/wiki/San_Marino">San Marino</a>
     */
    SM("San Marino"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Senegal">Senegal</a>
     */
    SN("Senegal"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Somalia">Somalia</a>
     */
    SO("Somalia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Suriname">Suriname</a>
     */
    SR("Suriname"),

    /**
     * <a href="http://en.wikipedia.org/wiki/South_Sudan">South Sudan</a>
     */
    SS("South Sudan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/S%C3%A3o_Tom%C3%A9_and_Pr%C3%ADncipe">Sao Tome and Principe</a>
     */
    ST("Sao Tome and Principe"),

    /**
     * <a href="http://en.wikipedia.org/wiki/El_Salvador">El Salvador</a>
     */
    SV("El Salvador"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Sint_Maarten">Sint Maarten (Dutch part)</a>
     */
    SX("Sint Maarten"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Syria">Syrian Arab Republic</a>
     */
    SY("Syrian Arab Republic"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Swaziland">Swaziland</a>
     */
    SZ("Swaziland"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Turks_and_Caicos_Islands">Turks and Caicos Islands</a>
     */
    TC("Turks and Caicos Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Chad">Chad</a>
     */
    TD("Chad"),

    /**
     * <a href="http://en.wikipedia.org/wiki/French_Southern_and_Antarctic_Lands">French Southern Territories</a>
     */
    TF("French Southern Territories"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Togo">Togo</a>
     */
    TG("Togo"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Thailand">Thailand</a>
     */
    TH("Thailand"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Tajikistan">Tajikistan</a>
     */
    TJ("Tajikistan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Tokelau">Tokelau</a>
     */
    TK("Tokelau"),

    /**
     * <a href="http://en.wikipedia.org/wiki/East_Timor">Timor-Leste</a>
     */
    TL("Timor-Leste"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Turkmenistan">Turkmenistan</a>
     */
    TM("Turkmenistan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Tunisia">Tunisia</a>
     */
    TN("Tunisia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Tonga">Tonga</a>
     */
    TO("Tonga"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Turkey">Turkey</a>
     */
    TR("Turkey"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Trinidad_and_Tobago">Trinidad and Tobago</a>
     */
    TT("Trinidad and Tobago"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Tuvalu">Tuvalu</a>
     */
    TV("Tuvalu"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Taiwan">Taiwan, Province of China</a>
     */
    TW("Taiwan, Province of China"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Tanzania">United Republic of Tanzania</a>
     */
    TZ("United Republic of Tanzania"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Ukraine">Ukraine</a>
     */
    UA("Ukraine"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Uganda">Uganda</a>
     */
    UG("Uganda"),

    /**
     * <a href="http://en.wikipedia.org/wiki/United_States_Minor_Outlying_Islands">United States Minor Outlying Islands</a>
     */
    UM("United States Minor Outlying Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/United_States">United States</a>
     */
    US("United States"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Uruguay">Uruguay</a>
     */
    UY("Uruguay"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Uzbekistan">Uzbekistan</a>
     */
    UZ("Uzbekistan"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Vatican_City">Holy See (Vatican City State)</a>
     */
    VA("Holy See"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Saint_Vincent_and_the_Grenadines">Saint Vincent and the Grenadines</a>
     */
    VC("Saint Vincent and the Grenadines"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Venezuela">Bolivarian Republic of Venezuela</a>
     */
    VE("Bolivarian Republic of Venezuela"),

    /**
     * <a href="http://en.wikipedia.org/wiki/British_Virgin_Islands">British Virgin Islands</a>
     */
    VG("British Virgin Islands"),

    /**
     * <a href="http://en.wikipedia.org/wiki/United_States_Virgin_Islands">Virgin Islands, U.S.</a>
     */
    VI("Virgin Islands, U.S."),

    /**
     * <a href="http://en.wikipedia.org/wiki/Vietnam">Viet Nam</a>
     */
    VN("Viet Nam"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Vanuatu">Vanuatu</a>
     */
    VU("Vanuatu"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Wallis_and_Futuna">Wallis and Futuna</a>
     */
    WF("Wallis and Futuna"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Samoa">Samoa</a>
     */
    WS("Samoa"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Yemen">Yemen</a>
     */
    YE("Yemen"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Mayotte">Mayotte</a>
     */
    YT("Mayotte"),

    /**
     * <a href="http://en.wikipedia.org/wiki/South_Africa">South Africa</a>
     */
    ZA("South Africa"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Zambia">Zambia</a>
     */
    ZM("Zambia"),

    /**
     * <a href="http://en.wikipedia.org/wiki/Zimbabwe">Zimbabwe</a>
     */
    ZW("Zimbabwe"),
    ;
    // @formatter:on


    private final String name;


    private Region(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getAlpha2() {
        return name();
    }


    public static Region getByCode(String code) {
        if (code == null) {
            return null;
        }

        if (code.length() == 2) {
            return getByAlpha2Code(code);
        }
        return null;
    }


    private static Region getByAlpha2Code(String code) {
        try {
            return Enum.valueOf(Region.class, code);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }



/*
    open static void main(String[] args) {
        for (Region value : Region.values()) {
            System.out.println(
                    " <mat-option value=\"" + value.toString() + "\">" + value.getName() + "</mat-option>"
            );
        }
    }*/
}

