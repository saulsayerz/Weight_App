const express = require('express');
const weightController = require('../controllers/weightController');

const router = express.Router();

router.get('/', weightController.getIndex);
router.get('/create', weightController.createWeightForm);
router.post('/', weightController.createWeight);
router.get('/:id', weightController.getDetail);
router.get('/edit/:id', weightController.editWeightForm);
router.put('/:id', weightController.updateWeight);

module.exports = router;
