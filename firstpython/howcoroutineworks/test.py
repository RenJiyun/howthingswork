def consumer():
    r = ''
    while True:
        print('======')
        n = yield r

        
        if not n:
            return
        print('[CONSUMER] consuming %s...' % n)
        r = '200 OK'

def producer(c):
    c.send(None)
    n = 0
    while n < 5:
        n += 1
        print('[PRODUCER] producing %s...' % n)
        r = c.send(n)
        print('[PRODUCER] consumer return: %s' %r)
    c.close()

