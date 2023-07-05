const Weight = require('../models/weightModel');

// Index page
exports.getIndex = async (req, res) => {
  try {
    const weights = await Weight.getAllWeights();
    const average = await Weight.getAverageWeight();
    res.render('index', { weights, average });
  } catch (error) {
    console.error('Error retrieving weights: ', error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

// Detail page
exports.getDetail = async (req, res) => {
  const weightId = req.params.id;
  try {
    const weight = await Weight.getWeightById(weightId);
    if (!weight) {
      return res.status(404).json({ error: 'Weight not found' });
    }
    res.render('detail', { weight });
  } catch (error) {
    console.error('Error retrieving weight: ', error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

// Create weight
exports.createWeight = async (req, res) => {
  const { date, maxWeight, minWeight } = req.body;
  try {
    await Weight.createWeight(date, maxWeight, minWeight);
    res.redirect('/');
  } catch (error) {
    console.error('Error creating weight: ', error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};

// Update weight
exports.updateWeight = async (req, res) => {
  const weightId = req.params.id;
  const { date, maxWeight, minWeight } = req.body;
  try {
    await Weight.updateWeight(weightId, date, maxWeight, minWeight);
    res.redirect('/');
  } catch (error) {
    console.error('Error updating weight: ', error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
};
