from flask import Flask
from controllers.weight_controller import index, show, create, edit

app = Flask(__name__, template_folder='views')

app.add_url_rule('/', 'index', index)
app.add_url_rule('/weight/<tanggal>', 'show', show)
app.add_url_rule('/weight/create', 'create', create, methods=['GET', 'POST'])
app.add_url_rule('/weight/<tanggal>/edit', 'edit', edit, methods=['GET', 'POST'])

if __name__ == '__main__':
    app.run()
