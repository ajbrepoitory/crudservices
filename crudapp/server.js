const express = require('express');
const app = express();

app.listen(8080, function() {
  console.log('listening on 3000')
	  app.get('/hello', function(req, res) {
	  res.send('Hello World')
	})
	  app.get('/', function(req, res) {
	  res.sendFile(__dirname+'/index.html')
	  
	})
})
