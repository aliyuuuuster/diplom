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
    <form class="upload-form" method="post" action="/images/predict" enctype="multipart/form-data">
        <div class="upload-form-header">Загрузите скетч</div>
        <div class="upload-form-content">

            <div class="form-group">
                <label for="image" class="control-label">Выберите изображение</label>
                <input type="file" class="form-control" id="image" name="file" placeholder="Изображение"
                       required="required">
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary btn-large full-width" value="Загрузить"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>