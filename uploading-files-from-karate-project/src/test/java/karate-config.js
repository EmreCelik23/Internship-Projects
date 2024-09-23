 function karateConfig() {
  var config = {
    tokenSirv: karate.callSingle('classpath:callables/getTokenForSirv.feature',
        {myClientId: "B2rMR9sIVcjOnjAbamumtrx5pyB", myClientSecret: "fUG+OE2lV6GJ5UOZrrkeMsc6ABb7Mhtuj7mN3OeHKig76xh5K5C2gGypAibgZmbTJa2a9+U1YMVJq8B22kaJjA=="}).response.token,
    pubKeyUploadCare: 'd5fcf2ead816fee5d9cd'
  };
  return config;
}