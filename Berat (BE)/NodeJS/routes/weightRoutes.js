const express = require('express');
const weightController = require('../controllers/weightController');

const router = express.Router();

router.get('/', weightController.getIndex);
router.get('/:id', weightController.getDetail);
router.post('/', weightController.createWeight);
router.put('/:id', weightController.updateWeight);

module.exports = router;
