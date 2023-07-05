const sinon = require('sinon');
const { expect } = require('chai');
const Weight = require('../models/weightModel');
const weightController = require('../controllers/weightController');

describe('Weight API Unit Tests', () => {
  describe('getIndex', () => {
    it('should return weights and average from the model', async () => {
      const getAllWeightsStub = sinon.stub(Weight, 'getAllWeights').resolves([{ /* mock weight data */ }]);
      const getAverageWeightStub = sinon.stub(Weight, 'getAverageWeight').resolves({ /* mock average data */ });

      const req = {};
      const res = { render: sinon.stub() };

      await weightController.getIndex(req, res);

      expect(res.render.calledOnce).to.be.true;
      expect(res.render.args[0][0]).to.equal('index');
      expect(res.render.args[0][1]).to.have.property('weights').that.is.an('array');
      expect(res.render.args[0][1]).to.have.property('average').that.is.an('object');

      getAllWeightsStub.restore();
      getAverageWeightStub.restore();
    });

    it('should handle errors and render the error template', async () => {
      const errorMessage = 'Internal Server Error';
      const getAllWeightsStub = sinon.stub(Weight, 'getAllWeights').rejects(new Error(errorMessage));

      const req = {};
      const res = { status: sinon.stub().returnsThis(), render: sinon.stub() };

      await weightController.getIndex(req, res);

      expect(res.status.calledOnce).to.be.true;
      expect(res.status.args[0][0]).to.equal(500);
      expect(res.render.calledOnce).to.be.true;
      expect(res.render.args[0][0]).to.equal('error');
      expect(res.render.args[0][1]).to.have.property('error').that.equals(errorMessage);

      getAllWeightsStub.restore();
    });
  });

  // Similar unit tests for other controller methods (getDetail, createWeight, updateWeight)...
});
