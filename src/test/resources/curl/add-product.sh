PORT=$1

curl -X POST \
  http://localhost:"$PORT"/api/product/add \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Example Product",
    "quantity": 11
    }'
