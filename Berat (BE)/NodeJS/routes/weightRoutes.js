const express = require('express');
const weightController = require('../controllers/weightController');

const router = express.Router();

router.get('/', weightController.getIndex);
router.get('/weights/:id', weightController.getDetail);
router.post('/weights', weightController.createWeight);
router.put('/weights/:id', weightController.updateWeight);

module.exports = router;
