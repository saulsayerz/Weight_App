const db = require('../config/database');

class Weight {
  static getAllWeights() {
    return new Promise((resolve, reject) => {
      const query = 'SELECT * FROM weights ORDER BY date DESC';
      db.query(query, (err, results) => {
        if (err) {
          reject(err);
          return;
        }
        resolve(results);
      });
    });
  }

  static getWeightById(weightId) {
    return new Promise((resolve, reject) => {
      const query = 'SELECT * FROM weights WHERE id = ?';
      db.query(query, [weightId], (err, results) => {
        if (err) {
          reject(err);
          return;
        }
        resolve(results[0]);
      });
    });
  }

  static getAverageWeight() {
    return new Promise((resolve, reject) => {
      const query = 'SELECT AVG(max_weight) AS averageMax, AVG(min_weight) AS averageMin FROM weights';
      db.query(query, (err, results) => {
        if (err) {
          reject(err);
          return;
        }
        resolve(results[0]);
      });
    });
  }

  static createWeight(date, maxWeight, minWeight) {
    return new Promise((resolve, reject) => {
      const query = 'INSERT INTO weights (date, max_weight, min_weight) VALUES (?, ?, ?)';
      db.query(query, [date, maxWeight, minWeight], (err, results) => {
        if (err) {
          reject(err);
          return;
        }
        resolve(results);
      });
    });
  }

  static updateWeight(weightId, date, maxWeight, minWeight) {
    return new Promise((resolve, reject) => {
      const query = 'UPDATE weights SET date = ?, max_weight = ?, min_weight = ? WHERE id = ?';
      db.query(query, [date, maxWeight, minWeight, weightId], (err, results) => {
        if (err) {
          reject(err);
          return;
        }
        resolve(results);
      });
    });
  }
}

module.exports = Weight;
