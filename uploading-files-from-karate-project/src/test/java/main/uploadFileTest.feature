Feature: This feature includes tests for uploading image files to Sirv and UploadCare

  Scenario: Uploading png file to Sirv
    Given url 'https://api.sirv.com/v2/files/upload'
    And param filename = '/galatasaray/championgs.png'
    And header Authorization = "Bearer " + tokenSirv
    And header Content-Type = 'image/png'
    And request read('classpath:resources/champion.png')
    When method POST
    Then status 200

  Scenario: Downloading a file
    Given url 'https://api.sirv.com/v2/files/download'
    And param filename = '/galatasaray/championgs.png'
    And headers {'authorization': #("Bearer " + tokenSirv), 'content-type': 'image/png'}
    When method GET
    Then status 200
    * def filePath = 'downloads/championgs.png'
    * karate.write(response, filePath)
    And print 'File saved to:', filePath


  Scenario: Uploading jpg file to UploadCare
    Given url 'https://upload.uploadcare.com/base/'
    And multipart file image = {read: 'classpath:resources/galatasaray_cl.jpg', filename: 'Galatasaray-ChampionsLeague.jpg'}
    And multipart field UPLOADCARE_PUB_KEY = pubKeyUploadCare
    When method POST
    Then status 200
    And print response

  Scenario: Getting a file
    Given url 'https://upload.uploadcare.com/info/'
    And param file_id = 'e32192a2-aacc-4e63-9ccd-c9708238b021'
    And param pub_key = pubKeyUploadCare
    When method GET
    Then status 200
    And print response

  Scenario: Checking the status of a file that is being uploaded
    Given url 'https://upload.uploadcare.com/from_url/status/'
    And param token = 'e32192a2-aacc-4e63-9ccd-c9708238b021'
    When method GET
    Then status 200
    And print response

  Scenario: Uploading files from URL
    Given url 'https://upload.uploadcare.com/from_url/'
    And multipart field pub_key = pubKeyUploadCare
    And multipart field source_url = 'https://assets.goal.com/images/v3/bltb799804256a03ec8/GettyImages-1716607855_(1).jpg?auto=webp&format=pjpg&width=828&quality=60'
    And multipart field filename = 'MauroIcardi-zZz.jpg'
    When method POST
    Then status 200
    And print response