const chai = require('chai');
const expect = chai.expect;
const request = require('supertest');
const app = require('../app');
const db = require('../config/database');
const Weight = require('../models/weightModel');

// Helper function to clear the weights table in the database
async function clearWeights() {
  await db.query('DELETE FROM weights');
}

describe('Weight API', () => {
  // Run before each test
  beforeEach(async () => {
    // Clear the weights table
    await clearWeights();
  });

  // Run after all tests
  after(async () => {
    // Clear the weights table
    await clearWeights();
    // Close the database connection
    db.end();
  });

  describe('GET /', () => {
    it('should return the list of weights', async () => {
      // Insert sample weights into the database
      await Weight.createWeight('2023-07-01', 70, 60);
      await Weight.createWeight('2023-07-02', 71, 61);

      // Make a GET request to the endpoint
      const res = await request(app).get('/');

      // Assert the response status code
      expect(res.statusCode).to.equal(200);

      // Assert the response body
      expect(res.body).to.have.property('weights');
      expect(res.body.weights).to.be.an('array');
      expect(res.body.weights).to.have.lengthOf(2);
    });
  });

  describe('POST /', () => {
    it('should create a new weight', async () => {
      const weightData = {
        date: '2023-07-03',
        maxWeight: 72,
        minWeight: 62
      };

      // Make a POST request to the endpoint
      const res = await request(app).post('/').send(weightData);

      // Assert the response status code
      expect(res.statusCode).to.equal(302); // Expecting a redirect response

      // Assert that the weight was created in the database
      const createdWeight = await Weight.getAllWeights();
      expect(createdWeight).to.be.an('array');
      expect(createdWeight).to.have.lengthOf(1);
      expect(createdWeight[0].date).to.equal(weightData.date);
      expect(createdWeight[0].max_weight).to.equal(weightData.maxWeight);
      expect(createdWeight[0].min_weight).to.equal(weightData.minWeight);
    });
  });

  describe('GET /:id', () => {
    it('should return a specific weight', async () => {
      // Insert a sample weight into the database
      const createdWeight = await Weight.createWeight('2023-07-04', 73, 63);

      // Make a GET request to the endpoint
      const res = await request(app).get(`/${createdWeight.id}`);

      // Assert the response status code
      expect(res.statusCode).to.equal(200);

      // Assert the response body
      expect(res.body).to.have.property('weight');
      expect(res.body.weight).to.be.an('object');
      expect(res.body.weight.date).to.equal(createdWeight.date);
      expect(res.body.weight.max_weight).to.equal(createdWeight.max_weight);
      expect(res.body.weight.min_weight).to.equal(createdWeight.min_weight);
    });

    it('should return an error for an invalid weight ID', async () => {
      // Make a GET request to the endpoint with an invalid weight ID
      const res = await request(app).get('/123');

      // Assert the response status code
      expect(res.statusCode).to.equal(404);
    });
  });

  describe('PUT /:id', () => {
    it('should update a specific weight', async () => {
      // Insert a sample weight into the database
      const createdWeight = await Weight.createWeight('2023-07-05', 74, 64);

      const updatedWeightData = {
        date: '2023-07-06',
        maxWeight: 75,
        minWeight: 65
      };

      // Make a PUT request to the endpoint
      const res = await request(app).put(`/${createdWeight.id}`).send(updatedWeightData);

      // Assert the response status code
      expect(res.statusCode).to.equal(302); // Expecting a redirect response

      // Assert that the weight was updated in the database
      const updatedWeight = await Weight.getWeightById(createdWeight.id);
      expect(updatedWeight).to.be.an('object');
      expect(updatedWeight.date).to.equal(updatedWeightData.date);
      expect(updatedWeight.max_weight).to.equal(updatedWeightData.maxWeight);
      expect(updatedWeight.min_weight).to.equal(updatedWeightData.minWeight);
    });

    it('should return an error for an invalid weight ID', async () => {
      const updatedWeightData = {
        date: '2023-07-06',
        maxWeight: 75,
        minWeight: 65
      };

      // Make a PUT request to the endpoint with an invalid weight ID
      const res = await request(app).put('/123').send(updatedWeightData);

      // Assert the response status code
      expect(res.statusCode).to.equal(404);
    });
  });
});
