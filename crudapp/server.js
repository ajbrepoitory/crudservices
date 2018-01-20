const express = require('express');
const bodyParser= require('body-parser')
const app = express();
app.use(bodyParser.urlencoded({extended: true}))
const MongoClient = require('mongodb').MongoClient

MongoClient.connect(process.env.MONGOURL, (err, database) => {
	// ... start the server
	if (err) return console.log(err)
	db = database.db('MONGODB')
	app.listen(8080, function() {
		console.log('listening on 8080')
		app.get('/hello', function(req, res) {
			res.send('Hello World')
		})
		app.get('/', function(req, res) {
			res.sendFile(__dirname+'/index.html')

		})
		app.post('/quotes', (req, res) => {
			db.collection('quotes').save(req.body, (err, result) => {
				if (err) return console.log(err)

				console.log('saved to database')
				res.redirect('/')
			})
		})
		app.get('/quotes', (req, res) => {
			db.collection('quotes').find().toArray(function(err, results) {
				console.log(results)
				res.send(results)
				//res.redirect('/')
			})
		})
		
	})

})
