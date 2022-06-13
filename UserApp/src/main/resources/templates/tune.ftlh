<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lorem ipsum dolor</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<div class="header">
    <a class="logo">Sketch to wireframes</a>
    <div class="header-right">
        <a href="/images/predict">Преобразование</a>
        <a href="/images/upload">Загрузка</a>
        <a href="/images/tune">Обучение</a>
    </div>
</div>
<div class="container">
    <form class="upload-form" action="/tune" method="post">
        <div class="upload-form-header">Произвести обучение модели в соответствии с загруженными файлами</div>
        <div class="upload-form-content">
            <div class="form-group">
                <input type="submit" class="btn btn-primary btn-large full-width" value="Обучение модели"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>