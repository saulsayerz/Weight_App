from flask import render_template, request, redirect
from models.weight_model import Weight

# Dummy data
weights = [
    Weight("2018-08-22", 50, 49),
    Weight("2018-08-21", 49, 49),
    Weight("2018-08-20", 52, 50),
    Weight("2018-08-19", 51, 50),
    Weight("2018-08-18", 50, 48)
]

# Handle division by 0, in case empty data
def countAvg(sorted_weights, type):
    if type == "max":
        return sum(w.max_weight for w in sorted_weights) / len(sorted_weights) if len(sorted_weights) else 0
    elif type == "min":
        return sum(w.min_weight for w in sorted_weights) / len(sorted_weights) if len(sorted_weights) else 0
    else: 
        return sum(sorted_weights) / len(sorted_weights) if len(sorted_weights) else 0

def index():
    sorted_weights = sorted(weights, key=lambda w: w.tanggal, reverse=True)
    diffs = [w.max_weight - w.min_weight for w in sorted_weights]
    avg_max = countAvg(sorted_weights, "max")
    avg_min = countAvg(sorted_weights, "min")
    avg_diff = countAvg(diffs, "normal")
    return render_template('index.html', weights=sorted_weights, diffs=diffs, avg_max=avg_max, avg_min=avg_min, avg_diff=avg_diff, len=len(diffs))

def show(tanggal):
    weight = next((w for w in weights if w.tanggal == tanggal), None)
    if weight:
        return render_template('show.html', weight=weight)
    else:
        return "Data tidak ditemukan."

def create():
    if request.method == 'POST':
        max_weight = int(request.form['max'])
        min_weight = int(request.form['min'])
        
        if max_weight < min_weight:
            error_message = "Max weight cannot be less than min weight."
            return render_template('create.html', error=error_message)
        
        new_weight = Weight(
            tanggal=request.form['tanggal'],
            max_weight=max_weight,
            min_weight=min_weight
        )
        weights.append(new_weight)
        return redirect('/')
    else:
        return render_template('create.html')

def edit(tanggal):
    weight = next((w for w in weights if w.tanggal == tanggal), None)
    if request.method == 'POST':
        max_weight = int(request.form['max'])
        min_weight = int(request.form['min'])
        if max_weight >= min_weight:
            weight.max_weight = max_weight
            weight.min_weight = min_weight
            return redirect('/')
        else:
            error_message = "Max weight cannot be less than min weight."
            return error_message
    else:
        if weight:
            return render_template('edit.html', weight=weight)
        else:
            return "Data tidak ditemukan."
