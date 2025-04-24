import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

// Kirim request ke test object Forecast_5Day
def response = WS.sendRequest(findTestObject('Object Repository/Forecast_5Day'))

// Verifikasi status response 200
WS.verifyResponseStatusCode(response, 200)

// Cetak status
println('[✓] Status code OK: 200')

// Parse response JSON
def json = new JsonSlurper().parseText(response.getResponseBodyContent())

// Tampilkan info prakiraan pertama
def forecast = json.list[0]
println("📅 Tanggal (dt): " + forecast.dt)
println("🌡️ Suhu: " + forecast.main.temp + "°C")
println("☁️ Cuaca: " + forecast.weather[0].description)
