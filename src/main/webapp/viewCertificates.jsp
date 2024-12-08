<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Certification Tracker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
            
        }

        .gallery-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr); /* 4 cards per row */
            gap: 20px; /* Space between cards */
            max-width: 1200px;
            margin: 0 auto;
        }

        .card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }

        .card img {
            width: 100%;
            height: auto;
            display: block;
        }

        .card-body {
            padding: 15px;
            text-align: center;
        }

        .card-title {
            font-size: 16px;
            font-weight: bold;
            color: #333;
        }

        .card-description {
            font-size: 14px;
            color: #777;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center; color: #007bff;">Certificates</h1>
    <div class="gallery-container">
        <!-- Static Certificate Cards -->
        <div class="card">
            <img src="images/ML.jpg" alt="Certificate 1">
            <div class="card-body">
                <div class="card-title">Machine Learning</div>
                <div class="card-description">Issued by IBM</div>
            </div>
        </div>
        <div class="card">
            <img src="images/aoop.jpg" alt="Certificate 2">
            <div class="card-body">
                <div class="card-title">Java</div>
                <div class="card-description">Issued by University of Alberta</div>
            </div>
        </div>
        <div class="card">
            <img src="images/aws.jpg" alt="Certificate 3">
            <div class="card-body">
                <div class="card-title">AWS</div>
                <div class="card-description">Issued by AWS Cloud</div>
            </div>
        </div>
        <div class="card">
            <img src="images/nsdc.jpg" alt="Certificate 4">
            <div class="card-body">
                <div class="card-title">Cloud NSDC</div>
                <div class="card-description">Issued by Cloud NSDC</div>
            </div>
        </div>
        
        <!-- Add more cards as needed -->
    </div>
</body>
</html>
