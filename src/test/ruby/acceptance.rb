require 'net/http'
require 'json'

host = ENV["GREETING_SERVICE_URI"]
expected_key = "greeting"

puts "Testing against service host: #{host}"

url = URI.parse(host)
req = Net::HTTP::Get.new(url.path)
res = Net::HTTP.start(url.host, url.port) {|http|
  http.request(req)
}

puts "Result: #{res.body}"

hash = JSON.parse(res.body)

if hash.has_key?(expected_key)
	puts "Found the expected key: #{expected_key}"
	puts "Acceptance test passed"
	exit 0
else
	puts "Could not find the expected key: #{expected_key}"
	puts "Acceptance test failed"
	exit 1
end
