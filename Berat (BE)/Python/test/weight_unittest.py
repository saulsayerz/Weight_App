import unittest
from controllers.weight_controller import weights
from models.weight_model import Weight

class WeightControllerTest(unittest.TestCase):
    def test_create_weight(self):
        initial_count = len(weights)

        # Simulate creating a new weight
        new_weight = Weight(tanggal='2018-08-23', max_weight=53, min_weight=48)
        weights.append(new_weight)

        # Check if the weight is added successfully
        self.assertEqual(len(weights), initial_count + 1)
        self.assertIn(new_weight, weights)

    def test_edit_weight(self):
        # Choose a weight from the existing data
        weight_to_edit = weights[0]

        # Simulate editing the weight
        weight_to_edit.max_weight = 55
        weight_to_edit.min_weight = 47

        # Check if the weight is edited successfully
        self.assertEqual(weight_to_edit.max_weight, 55)
        self.assertEqual(weight_to_edit.min_weight, 47)

    def test_delete_weight(self):
        initial_count = len(weights)

        # Choose a weight from the existing data
        weight_to_delete = weights[0]

        # Simulate deleting the weight
        weights.remove(weight_to_delete)

        # Check if the weight is deleted successfully
        self.assertEqual(len(weights), initial_count - 1)
        self.assertNotIn(weight_to_delete, weights)

if __name__ == '__main__':
    unittest.main()
