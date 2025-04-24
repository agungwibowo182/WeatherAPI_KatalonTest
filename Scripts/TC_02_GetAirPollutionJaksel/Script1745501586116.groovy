import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

// Send request
def response = WS.sendRequest(findTestObject('Object Repository/AirPollution_Current'))

// Verify status code
WS.verifyResponseStatusCode(response, 200)

// Print response
println('[✔] Status code: 200')

// Parse JSON
def json = new JsonSlurper().parseText(response.getResponseBodyContent())

// Body assertions
assert json.list[0].main.aqi in 1..5 : "Invalid AQI"
println("AQI: " + json.list[0].main.aqi)

// Optional schema validation
WS.verifyElementPropertyValue(response, 'list[0].main.aqi', json.list[0].main.aqi)
