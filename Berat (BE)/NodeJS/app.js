const express = require('express');
const weightRoutes = require('./routes/weightRoutes');

const app = express();
const port = 3000;

app.set('view engine', 'ejs');

var cors = require('cors')

app.use(express.json());
app.use(cors())
app.use(
  express.urlencoded({
    extended: true,
  })
);

app.use('/', weightRoutes);

app.listen(port, () => {
  console.log('Server started on port 3000');
});
