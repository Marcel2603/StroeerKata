FROM node:alpine
COPY src /opt
CMD ["node", "/opt/index.js"]
