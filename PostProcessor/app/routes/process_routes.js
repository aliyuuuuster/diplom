elementTypes = {
    singleRow: [
        'text_field',
        'radio_button_unchecked',
        'radio_button_checked',
        'checkbox_unchecked',
        'checkbox_checked',
        'button',
        'chip',
    ],
    multiRow: [
        'tooltip',
        'text_area',
        'switch_enabled',
        'switch_disabled',
        'slider',
        'menu',
        'label',
        'grid_list',
        'floating_action_button',
        'dropdown_menu',
        'data_table',
        'card',
        'alert',
        'image',
    ]
};

let carouselId = 0;

class Element {
    constructor({label, positions}) {
        // console.log(positions);
        this.label = label;
        this.position = positions;
        this.y1 = positions[0];
        this.x1 = positions[1];
        this.y2 = positions[2];
        this.x2 = positions[3];
    }

    _getSingleRowElementTag() {
        switch (this.label) {
            case `checkbox_unchecked`:
                return `input ${this._getSingleRowElementTagPosition()} type="checkbox"`;
            case `checkbox_checked`:
                return `input ${this._getSingleRowElementTagPosition()} type="checkbox" checked`;
            case `radio_button_unchecked`:
                return `input ${this._getSingleRowElementTagPosition()} type="radio"`;
            case `radio_button_checked`:
                return `input ${this._getSingleRowElementTagPosition()} type="radio" checked`;
            case `text_field`:
                return `input ${this._getSingleRowElementTagPosition()} type="text" placeholder="${this.label}"`;
            case `chip`:
            case `button`:
                return `input ${this._getMultiRowElementTagPosition()} type="button" value="Submit"`;
        }
    }

    _getMultiRowElementTag() {
        switch (this.label) {
            case `tooltip`:
                return `<div ${this._getSingleRowElementTagPosition()} class="tooltip">Lorem ipsum</div>`;
            case `text_area`:
                return `<textarea ${this._getMultiRowElementTagPosition()} placeholder="text_area"></textarea>`;
            case `switch_enabled`:
                return `<div ${this._getSingleRowElementTagPosition()} class="switch_enabled"></div>`;
            case `switch_disabled`:
                return `<div ${this._getSingleRowElementTagPosition()} class="switch_disabled"></div>`;
            case `slider`:
                return this._getSliderHtmlCode();
            case `menu`:
                return this._getMenuHtmlCode();
            case `label`:
                return `<label ${this._getSingleRowElementTagPosition()} class="label">Lorem</label>`;
            case `floating_action_button`:
                return `<div ${this._getMultiRowElementTagPosition()} class="floating_action_button">+</div>`;
            case `grid_list`:
                return this._getGridListHtmlCode();
            case `dropdown_menu`:
                return this._getDropdownMenuHtmlCode();
            case `data_table`:
                return this._getTableHtmlCode();
            case `card`:
                return this._getCardHtmlCode();
            case `alert`:
                return this._getAlertHtmlCode();
            case `image`:
                return `<svg class="bd-placeholder-img card-img-top" ${this._getMultiRowElementTagPosition()} xmlns="http://www.w3.org/2000/svg" role="img" aria-label="" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#868e96"></rect></svg>`;
        }
    }

    _getSliderHtmlCode() {
        carouselId++;
        return `<div id="carouselExampleSlidesOnly-${carouselId}" class="carousel slide" data-bs-ride="carousel" ${this._getMultiRowElementTagPosition()}>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Second slide" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#666"></rect><text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text></svg>
    </div>
  </div>
</div>`;
    }

    _getMenuHtmlCode() {
        let code = `<ul class="list-group" ${this._getMultiRowElementTagPosition()}>`;
        let elementsInside = parseInt((this.y2 - this.y1) / 41);
        for(let i = 0; i < elementsInside; i++) {
            code += `<li class="list-group-item">An item</li>`;
        }
        code += `</ul>`;
        return code;
    }

    _getGridListHtmlCode() {
        return `<div ${this._getMultiRowElementTagPosition()}>
<ul class="list-group list-group-horizontal">
  <li class="list-group-item">An item</li>
  <li class="list-group-item">A second item</li>
  <li class="list-group-item">A third item</li>
</ul>
<ul class="list-group list-group-horizontal-sm">
  <li class="list-group-item">An item</li>
  <li class="list-group-item">A second item</li>
  <li class="list-group-item">A third item</li>
</ul>
</div>`;
    }

    _getDropdownMenuHtmlCode() {
        return `<div class="dropdown" ${this._getMultiRowElementTagPosition()}>
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    Dropdown button
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="#">Action</a></li>
    <li><a class="dropdown-item" href="#">Another action</a></li>
    <li><a class="dropdown-item" href="#">Something else here</a></li>
  </ul>
</div>`;
    }

    _getTableHtmlCode() {
        return `<table class="table" ${this._getMultiRowElementTagPosition()}">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Lorem</th>
      <th scope="col">Ipsum</th>
      <th scope="col">Dolor</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>sit</td>
      <td>amet</td>
      <td>@consectetur</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>adipiscing</td>
      <td>elit</td>
      <td>Pellentesque</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>vitae</td>
      <td>sem</td>
      <td>quis</td>
    </tr>
  </tbody>
</table>`;
    }

    _getCardHtmlCode() {
        return `<div class="card" ${this._getMultiRowElementTagPosition()}>
  <svg class="bd-placeholder-img card-img-top" width="100%" height="180" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Image cap" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Lorem</title><rect width="100%" height="100%" fill="#868e96"></rect><text x="50%" y="50%" fill="#dee2e6" dy=".3em">Lorem ipsum</text></svg>
  <div class="card-body">
    <h5 class="card-title">Lorem ipsum</h5>
    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vitae sem quis sapien malesuada auctor vitae et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
  </div>
</div>`;
    }

    _getAlertHtmlCode() {
        return `<div class="alert alert-primary" ${this._getMultiRowElementTagPosition()} role="alert">Lorem ipsum dolor sit amet.</div>`;
    }

    _getMultiRowElementTagPosition() {
        return `style="position: absolute; left: ${this.x1}px; top: ${this.y1}px; width: ${this.x2 - this.x1}px; height: ${this.y2 - this.y1}px;"`;
    }

    _getSingleRowElementTagPosition() {
        return `style="position: absolute; left: ${this.x1}px; top: ${this.y1}px;"`;
    }

    _isSingleRowElement() {
        return elementTypes.singleRow.includes(this.label);
    }

    getElementHtml() {
        return this._isSingleRowElement() ? `<${this._getSingleRowElementTag()}/>` : this._getMultiRowElementTag();
    }
}

function generateHtml(data) {
    console.log(data);
    function mainGenerate(data) {

        let html = `<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lorem ipsum dolor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <style>
        .floating_action_button {
            border: 1px solid black;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 2em;
            border-radius: 50%;
        }
    </style>
  </head>
  <body>`;
        data.map((el) => {
            let elem = new Element(el);
            html += elem.getElementHtml();
        });

        html += `<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>`;

        return html;
    }

    return mainGenerate(data);
}

module.exports = function (app, bodyParser) {
    app.post('/process', bodyParser, function (request, response) {
        let body = request.body.message;

        let htmlResult = generateHtml(body);
        response.send(htmlResult);

    });
}
